import React, {Fragment, useEffect, useState} from 'react';
import {BrowserRouter as Router, Route, Routes, useParams, Switch} from 'react-router-dom';
import NavBar from '../NavBar.js';
import PirateContainer from './PirateContainer.js';
import PirateDetail from '../components/pirates/PirateDetail.js';

const MainContainer = () => {

  return (
    <div>
      <NavBar/>
        <Routes>
          <Route path="/pirates/*" element={<PirateContainer/>}/>
        </Routes>
    </div>
  )
}

export default MainContainer;
