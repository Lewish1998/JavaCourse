import React, {Component, Fragment, useEffect, useState} from 'react';
import {BrowserRouter as Router, Route, Switch, Routes} from 'react-router-dom';
import PirateList from '../components/pirates/PirateList';
import Request from '../helpers/request.js';

const PirateContainer = () => {

  const [pirates, setPirates] = useState([])

  useEffect(() => {
    getPirates()
  }, [])

  const getPirates = () => {
    const request = new Request()
    request.get("/api/pirates")
    .then((data) => {
      setPirates(data)
    })
  }


  return (
    <div>
      <Routes>
        <Route path="/" element={<PirateList pirates={pirates}/>}/>
      </Routes>
    </div>
  )


}




export default PirateContainer;
