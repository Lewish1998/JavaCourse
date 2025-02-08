# React Requests - Promise.all()

## Learning Objectives

- Understand how to make several requests using Promise.all()

## Duration
30 minutes.

# Intro

So we have been able to get all of the Pirates from our API but we may also want to use all of the ships and raids as well somewhere down the line. (We will be using these when it comes to creating and editing a pirate so we may as well deal with this now. ) Well we can make new requests in our PirateContainer to get all pirates, ships and raids.

As these requests all take time we can make sure that all of these will resolve in succession before we move on. To do this we can use Promise.all() method.

## Promise.all

Promise.all takes in an array of promises. In our case it will be the promises returned from our fetch requests. We can then execute all of the promises in turn and return an array with arrays of the result of each promise.

Let's add change our `PirateContainer`, we will create 3 promises one for each of our elements we want to get.

```js
// PirateContainer

componentDidMount(){
  const request = new Request();

  const piratePromise = request.get('/api/pirates'); // A PROMISE
  const shipPromise = request.get('/api/ships'); // A PROMISE
  const raidPromise = request.get('/api/raids'); // A PROMISE


}
```

Now we can pass all of these promises to promise.all().

```js
// PirateContainer

componentDidMount(){
  const request = new Request();

  const piratePromise = request.get('/api/pirates'); // A PROMISE
  const shipPromise = request.get('/api/ships'); // A PROMISE
  const raidPromise = request.get('/api/raids'); // A PROMISE

  Promise.all([piratePromise, shipPromise, raidPromise])
}
```

Promise.all() returns us another promise so we can now use `.then()` to see our data.

```js
// PirateContainer

componentDidMount(){
  const request = new Request();

  const piratePromise = request.get('/api/pirates'); // A PROMISE
  const shipPromise = request.get('/api/ships'); // A PROMISE
  const raidPromise = request.get('/api/raids'); // A PROMISE

  Promise.all([piratePromise, shipPromise, raidPromise])
  .then((data) => {
    console.log(data);
  })
}
```

So now we should see an array of arrays. One for pirates, ships and raids.

We can set the state using the index of the arrays in the response.

Add in the ships and raids to the initial state:

```js
// PirateContainer

constructor(props){
  super(props);
  this.state = {
    pirates: [],
    ships:[],
    raids: []
  }

}
```

```js
// PirateContainer

componentDidMount(){
  const request = new Request();

  const piratePromise = request.get('/api/pirates'); // A PROMISE
  const shipPromise = request.get('/api/ships'); // A PROMISE
  const raidPromise = request.get('/api/raids'); // A PROMISE

  Promise.all([piratePromise, shipPromise, raidPromise])
  .then((data) => {
    this.setState(
      {
        pirates: data[0],
        ships: data[1],
        raids: data[2]
      }
    )
  })
}
```

And check this in our React DevTools to make sure the state updates.



# Summary
- Learned how to use promise.all() to make several requests to an API.

# Next Lesson
- Edit a pirate.
