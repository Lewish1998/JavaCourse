import React, {Component, Fragment} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import PirateList from '../components/pirates/PirateList';
import Request from '../helpers/request';
import PirateDetail from '../components/pirates/PirateDetail'

class PirateContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      pirates: []
    }

      this.findPirateById = this.findPirateById.bind(this);
  }

  componentDidMount(){
    const request = new Request();

    request.get('/api/pirates')
    .then((data) => {
      this.setState({pirates: data})
    })
  }

  findPirateById(id){
    return this.state.pirates.find((pirate) => {
      return pirate.id === parseInt(id);
    });
  }

  render(){
    return(
      <Router>
      <Fragment>
      <Switch>
      <Route exact path="/pirates/:id" render={(props) =>{
        const id = props.match.params.id;
        const pirate = this.findPirateById(id);
        return <PirateDetail pirate={pirate}/>
      }}/>

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
