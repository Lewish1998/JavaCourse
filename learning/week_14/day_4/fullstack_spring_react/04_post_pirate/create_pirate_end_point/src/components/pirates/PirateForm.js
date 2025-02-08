import React, {Component} from 'react';

class PirateForm extends Component {
  constructor(props){
    super(props);
    this.state = {
      pirate: {
        firstName: "",
        lastName: "",
        age: 0,
        ship: null
      }
    }

    this.handleChange = this.handleChange.bind(this);
    this.handleShip = this.handleShip.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event){
    let propertyName = event.target.name;
    let pirate = this.state.pirate
    pirate[propertyName] = event.target.value;
    this.setState({pirate: pirate})
  }

  handleShip(event){
    const index = parseInt(event.target.value)
    const selectedShip = this.props.ships[index]
    let pirate = this.state.pirate;
    pirate['ship'] = selectedShip
    this.setState({pirate: pirate})
  }

  handleSubmit(event){
    event.preventDefault();
    this.props.onCreate(this.state.pirate);
  }

  render(){

    if(this.props.ships.length === 0 ){
       return <p>Loading...</p>
    }

    const shipOptions = this.props.ships.map((ship, index) => {
      return <option key={ship.id} value={index}>{ship.name}</option>
    });

    return (
      <div>
      <form onSubmit={this.handleSubmit}>
      <input type="text" placeholder="First Name" name="firstName" onChange={this.handleChange} value={this.state.pirate.firstName} />
      <input type="text" placeholder="Last Name" name="lastName" onChange={this.handleChange} value={this.state.pirate.lastName} />
      <input type="number" placeholder="Age" name="age" onChange={this.handleChange} value={this.state.pirate.age}/>
      <select name="ship" onChange={this.handleShip} defaultValue="select-ship">
        <option disabled value="select-ship">Select a ship</option>
        {shipOptions}
      </select>
      <button type="submit">Save</button>
      </form>
      </div>
    )
  }
}

export default PirateForm;
