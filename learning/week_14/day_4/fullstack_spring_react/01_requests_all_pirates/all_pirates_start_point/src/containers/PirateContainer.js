import React, {Component, Fragment} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import PirateList from '../components/pirates/PirateList';

class PirateContainer extends Component {
  constructor(props){
    super(props);
  }

  render(){
    return(
      <p>I'm the pirate container.</p>
    )
  }

}

export default PirateContainer;
