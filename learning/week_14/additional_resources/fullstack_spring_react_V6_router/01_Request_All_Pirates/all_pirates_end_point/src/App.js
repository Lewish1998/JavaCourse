import React, { Component } from 'react';
import {BrowserRouter as Router, Route, Routes, useParams, Switch} from 'react-router-dom';



import MainContainer from './containers/MainContainer'

function App(){
  return(
    <Router>
    <MainContainer/>
    </Router>
  )
}

export default App;
