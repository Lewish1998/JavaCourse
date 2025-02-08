import React, { Component } from 'react';
import { Router } from 'react-router-dom';


import MainContainer from './containers/MainContainer'

function App(){
  return(
    <Router>
    <MainContainer/>
    </Router>
  )
}

export default App;
