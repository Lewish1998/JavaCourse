# React Requests - Pirate API

## Learning Objectives

- Understand how to make a call to our Pirate API using React.
- Understand how to write custom routes to get back the data we want.


## Duration
1 hour 30 minutes

# Intro

You all wrote awesome applications using the countries RESTful API in vanilla JS. In this lesson we are going to use React to make a HTTP request to our own Pirate API. As we saw with the Comments app, by setting the received data on our state, we trigger a re-render of our application, which we can use to populate our UI. Here we will see how React's component lifecycle methods can help us perform HTTP requests. We will also be using stateless functional components where possible.

# Rest APIs using HAETOS

Do you remember what Spring Data Rest gave us? It gave us HAETOS route that adhered to the 7 restful routes. The good news is that we can easily use these routes to connect to our own API.

If you haven't already, go and grab the JSON formatter extension for Chrome:

https://chrome.google.com/webstore/detail/json-formatter/bcjindcccaagfpapjjmafapmmgkkhgoa?hl=en

This will make it a lot easier to read our JSON results.

Let's have a look at the api we are going to use today - the PirateService api.

> Hand out start point and have students.
> Run the PirateService in IntelliJ and keep running for all lessons in this series.

As you can see this back end is the same as we created last week with projections set for all 3 models to get back all the data associated with each.


### Task
Run the back-end application in IntelliJ.
Visit the routes in your browser and look at the data.

So today we will be using 2 different types of URL in our apps.

We will be using `/pirates` in React to get back our list of pirates but also `/pirates` to hit our API

SO React will use http://localhost:3000/pirates and Spring will use http://localhost:8080/pirates to hit the API. Yuck! This could get really really confusing. So let's make it clearer by changing the base route for Spring so that we need to hit `/api/pirates` to get back the data from Spring.

In the Java code open application.properties and add the following line.

```xml
<!-- application.properties -->

server.servlet.context-path=/api
```

Now visit the browser and go to http://localhost:8080/api/pirates.

Great we now have our data back on this route so we will use that moving forward for whatever data we want. So if we wanted all ships it would be `/api/ships` etc...

So the main route we are going to use today is this one

http://localhost:8080/api/pirates

This gives us ALL the pirate data.

Let's have a go.

## React request

> Have students open front end code and look at it in atom. Note that we have a NavBar, route and css included.

> Run npm install and npm start to kick off the server.

Here we have a React application set up with a main controller. It is in here that we will set up routes to the top level components for pirates, ships and raids. We also have a PirateController which will then manage internal routing for pages concerning pirates. We will also fetch our pirates in here.

First we will add a route to the PirateContainer in MainContainer.

```js
// MainContainer.js
import PirateContainer from './PirateContainer'; // ADDED

//AS BEFORE
const MainContainer = () => {

  return (
    <Router>
    <React.Fragment>
    <NavBar/>
    <Switch>
    <Route path="/pirates" component={PirateContainer}/> // ADDED
    </Switch>


    </React.Fragment>
    </Router>
  )
}
```

Ok so we will be able to code up our controller and when we go to `/pirates` it will launch into this.

Our Pirate container will deal with the pirate specific routes. We will start with all pirates so will need this route to render our PirateList component. We don't need to pass a path to this route as this will be our default.

Let's code up the PirateContainer.

```js

// PirateContainer.js

import React, {Component, Fragment} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import PirateList from '../components/pirates/PirateList';

class PirateContainer extends Component {
  constructor(props){
    super(props);
  }

  render(){
    return(
      <Router>
        <Fragment>
          <Switch>
          <Route render={(props) => {
            return <PirateList  />
        }} />
          </Switch>
        </Fragment>
      </Router>
    )
  }

}

export default PirateContainer;

```

Now if we look at the browser and go to `localhost:3000/pirates` we should see the text `I am a list of pirates`.

## Requests

So our PirateList is going to need a list of pirates.

To get this we will be making a request to our API

As we will no doubt be making multiple requests to get data we can abstract out the method to a helper. Just like we did in Vanilla JS. We have set up a request helper and coded in the `get` method like we had before.

Open `request.js` in the helpers folder.

```js
//request.js

class Request {

  get(url) {
    return fetch(url)
    .then((res) => res.json());
  } // ADDED


}

export default Request;
```

And import this into `PirateContainer` to use.

```js
//PirateContainer.js

import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import PirateList from '../components/pirates/PirateList';
import Request from '../helpers/request'; // ADDED

```

Now in our `PirateContainer` we will fetch the data in `componentDidMount` and we will log out the data we get back initially.

Let's start by setting up the state in the constructor.

```js
// PirateContainer.js

constructor(props){
  super(props);
  this.state = {
    pirates: []
  } // ADDED
}

```

Next we will add `componentDidMount` method and set up our request.

```js
//PirateContainer.js

class PirateContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      pirates: []
    }
  }

  componentDidMount(){
    const request = new Request();

    request.get('/api/pirates')
    .then((data) => {
      console.log(data)
    })
  }
}
```

## Proxy

Next thing to deal with is when we make a fetch request in React the request is actually sent to `localhost:3000/api/pirates`.

We don't want this... we want to hit `localhost:8080/api/pirates`.

We could pass in the full url into the get but then this would give us CORS errors that we would need to deal with in our Spring app.

A better way around this is to assign a `proxy` value in our `package.json`

With the proxy any requests that are sent out of the application will use the proxy rather than reacts. So if we set the proxy to `http://localhost:8080/` any fetch request will use the Spring server.

So our fetch `/pirates` will actually resolve to `http://localhost:8080/api/pirates`.

```json
"browserslist": [
    ">0.2%",
    "not dead",
    "not ie <= 11",
    "not op_mini all"
  ],
  "proxy": "http://localhost:8080/" */ ADDED /*

```

> Note you may have to restart the server for this to take effect.

Cool so now we are able to get the data back.

If we look at the data we see an array with our pirates embedded in the results.

So now all we need to do is set the state.

```js
// PirateContainer.js

componentDidMount(){
  const request = new Request();

  request.get('/api/pirates')
  .then((data) => {
    this.setState({pirates: data})
  })
}
  ```

Let's amend the route and pass in props to the PirateList.

Render gives us access to props and allows us to pass props to a component. (Just like the normal render method).

```js
//PirateContainer.js

<Route render={(props) =>{
        return <PirateList pirates={this.state.pirates}/>
      }}/>
```

In `PirateList` we can now use our React DevTools and check that we have the array of pirates as props.

## Checking the data

As the request may take some time we only want to start creating our Pirate components when we have data.

We will put in a check at top of PirateList to make sure we have it.

```js
// PirateList.js

if (props.pirates.length === 0){
  return (<p>Loading...</p>)
}

return (
  <ul className="component-list">
   <li>Im in the pirate list!</li>
 </ul>
)
```

Cool we can now see the pirates array being logged out from within `PirateList`.

We will change the `div` and instead we will use a `ul` to display a list of Pirate components.

So first we want to create an `li` tag for each Pirate. To do this we want to loop over the array of pirates and return a collection of `li` tags with a `Pirate` component in each. We also want each individual `Pirate` object passed into them in turn.

We can use `Array.map` to achieve this.

We will also add a surrounding div for CSS purposes. The div will have a `className` of `component` to apply the CSS.

```js
//PirateList.js

const pirates = props.pirates.map((pirate, index) => {
  return (
    <li key={index} className="component-item">
    <div className="component">
    <Pirate pirate={pirate} />
    </div>
    </li>
  )
}) // ADDED

return (
  <ul className="component-list">
   <li>Im in the pirate list!</li>
 </ul>
)
```

Next we will render the `li` elements inside the ul.

```js
//PirateList.js

return (
  <ul className="component-list">
    {pirates}
  </ul>
) // MODIFIED
```


Cool so we should now see a list of Pirates!

If you look at the Pirate component you will notice that we are destructuring the pirate from the props in the function. Using {pirate} instead of props gives us direct access to the pirate passed in as part of the props. This is to save us having to write `props.pirate` in multiple places!

```js
//Pirate.js

import React, {Fragment} from 'react';

const Pirate = ({pirate}) => {

  if (!pirate){
    return "Loading..."
  }
  return (
    <Fragment>
    <p>
    {pirate.firstName} {pirate.lastName}
    </p>
    <p>Age: {pirate.age}</p>
    <p>Ship: {pirate.ship.name}</p>
    </Fragment>
  )
}

export default Pirate;


```

Fantastic we now have a list of pirates showing all their details.

### Task
- Fetch all Ships and raids.

## Summary
- Learned how to make a call to our Pirate API using React.

#### Next Lesson
- Display a single pirate details
