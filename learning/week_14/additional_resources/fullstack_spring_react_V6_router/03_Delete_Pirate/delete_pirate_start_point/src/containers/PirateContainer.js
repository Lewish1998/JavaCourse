import React, {Component, Fragment, useEffect, useState} from 'react';
import {BrowserRouter as Router, Route, Switch, Routes, useParams} from 'react-router-dom';
import PirateList from '../components/pirates/PirateList';
import PirateDetail from '../components/pirates/PirateDetail';
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

  const findPirateById = (id) => {
    return pirates.find((pirate) => {
      return pirate.id === parseInt(id);
    })
}

  const PirateDetailWrapper = () => {
    const { id } = useParams();
    let foundPirate = findPirateById(id)
    return <PirateDetail pirate={foundPirate}/>;
  };


  return (
      <Routes>
        <Route path="/:id" element={
          <PirateDetailWrapper/>
        }/>
      <Route path="/" element={<PirateList pirates={pirates}/>}/>
      </Routes>
  )


}




export default PirateContainer;
