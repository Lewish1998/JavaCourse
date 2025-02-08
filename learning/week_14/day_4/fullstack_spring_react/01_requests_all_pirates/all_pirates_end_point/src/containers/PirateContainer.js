import React, {Component, Fragment} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import PirateList from '../components/pirates/PirateList';
import Request from '../helpers/request';

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
      this.setState({pirates: data})
    })
  }

  render(){
    return(
      <Router>
      <Fragment>
      <Switch>
      <Route render={(props) =>{
        return <PirateList pirates={this.state.pirates}/>
      }}/>
      </Switch>
      </Fragment>
      </Router>
    )
  }

}

export default PirateContainer;
