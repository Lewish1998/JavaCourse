# React Requests - Single Pirate from API

## Learning Objectives

- Understand how to make a call to our Pirate API using React to fetch a single Pirate.
- Understand how to use built in props in routes to pass Id as prop.


## Duration
1 hour.

# Intro

So we have been able to get all of the Pirates from our API but we may also want to display more details about a single pirate. Well we can define a route using the Pirates ID to display a single pirate and create a different component for additional pirate details.

# Routes.

> Use end point from all pirates lesson to start this lesson.

So we will need another route to get our single Pirate. This route will follow the pattern `/pirates/1`. Where 1 is the pirates `id`.

As the id will be different each time we will need to use params to get the ID from the url. The url params are accessible using the props passed into render. The pattern for this will be `/pirates/:id`.

Let's start by defining the route in our `PirateContainer`. So we are sure no other routes will match we make the path `exact`.

(Our route to all pirates is default so this will always be the last route.)

```js
// PirateContainer.js
<Router>
<Fragment>
<Switch>
<Route exact path="/pirates/:id" render={(props) =>{

}}/>

<Route render={(props) =>{
  return <PirateList pirates={this.state.pirates}/>
}}/>
</Switch>
</Fragment>
</Router>
```

To get the id from the url we use `props.match.params.id`. This will bring back the id as a string.

```js
// PirateContainer.js

<Route exact path="/pirates/:id" render={(props) =>{
  const id = props.match.params.id;
}
}/>
```

Next we need to find the pirate with that id. We already have all the pirates in our state so we will write a function above to find the pirate by id. We will then use this in our route to get the pirate.

As the id from the params is a string we will also need to change it to an int in our find function.

```js
// PirateContainer.js

componentDidMount(){
  // AS BEFORE
}

findPirateById(id){
  return this.state.pirates.find((pirate) => {
    return pirate.id === parseInt(id);
  });
} // ADDED

render(){
  // AS BEFORE
  <Route exact path="/pirates" render={(props) =>{
          return <PirateList pirates={this.state.pirates}/>
        }}/>

  <Route exact path="/pirates/:id" render={(props) =>{
    const id = props.match.params.id;
    const pirate = this.findPirateById(id); // Added
    }
  } />
}
```

And bind the new method in the constructor.

```js
// PirateContainer.js

constructor(props){
  super(props);
  this.state = {
    pirates: []
  }

  this.findPirateById = this.findPirateById.bind(this);
}
```

When we get back a single pirate we probably want to show more details. Like maybe the list of raids that the pirate has been on.

We will create a new component called `PirateDetail` for this and pass the `Pirate` as props.

We will also import it just now even though this will give us an error until we have created the component.


```js
// PirateContainer.js

import PirateDetail from '../components/pirates/PirateDetail'

// AS BEFORE

<Route exact path="/pirates/:id" render={(props) =>{
  const id = props.match.params.id;
  const pirate = this.findPirateById(id);
  return <PirateDetail pirate={pirate}/>
}}/>

```

Now we will create the `PirateDetail` component.

```bash
touch src/components/pirates/PirateDetail.js

```

And code this up. We will bring in the basic Pirate component and render this then add details below. We will also make sure the passed in pirate isn't null. If it is we will return `Loading...`

As we want to show the list of raids for the pirate we will map over the pirates raids from the API and create an `li` tag for each one.

We will then render this in a `ul` below the pirate component.



```js
// PirateDetail.js

import React from 'react';
import Pirate from "./Pirate"

const PirateDetail = ({pirate}) => {


    if (!pirate){
      return "Loading..."
    }

    const piratesRaids = pirate.raids.map((raid, index) => {
      return <li key={index}>{raid.location}</li>
    })

    return (
      <div className = "component">
      <Pirate pirate = {pirate}/>
      <p>Raids:</p>
      <ul>
      {piratesRaids}
      </ul>
      </div>
    )
  }

export default PirateDetail;


```

Now we need a Link somewhere to take us to that Route. We need this to go somewhere that we have access to the individual pirate and it's id.

In `Pirate` component we will wrap the Pirates name in a Link. We will change the `<p>` tag surrounding the pirates name to a `<Link>`.

We also need to define the url outside the return as string concatenation won't work inside the Link tag.

We will then build the url to hit using the pirates id.

```js
// Pirate.js

if (!pirate){
  return "Loading..."
}

const url = "/pirates/" + pirate.id; // ADDED

return (
  <Fragment>
  <Link to = {url} className="name">
  {pirate.firstName} {pirate.lastName}
  </Link> //MODIFIED
  <p>Age: {pirate.age}</p>
  <p>Ship: {pirate.ship.name}</p>
  </Fragment>
)
```

And import Link at the top of the file

```js
// Pirate.js

import React, {Fragment} from 'react';
import {Link} from 'react-router-dom'; // ADDED

```
Great so if we refresh our list click on the name of a pirate in our list it should now hit our new route in the container and render the full pirate details.

# Task
 - Get one Ship with a list of pirates.
 - Get one Raid with a list of pirates.

# Summary
- Learned how to use the data to fetch a pirates details.

#Next Lesson
- Delete a pirate
