import React, {Fragment, useEffect, useState} from 'react';
import {BrowserRouter as Router, Route, Routes, useParams} from 'react-router-dom';
import NavBar from '../NavBar.js';
import PirateContainer from './PirateContainer.js';
import PirateDetail from '../components/pirates/PirateDetail.js';

const MainContainer = () => {

  return (

    <React.Fragment>
    <NavBar/>
    <Routes>

    </Routes>


    </React.Fragment>

  )
}

export default MainContainer;
