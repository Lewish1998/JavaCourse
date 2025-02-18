import React, {Fragment} from 'react';


const Pirate = ({pirate}) => {

  if (!pirate){
    return "Loading..."
  }
  const url = "/pirates/" + pirate.id;
  return (
    <Fragment>
    <p>
    {pirate.firstName} {pirate.lastName}
    </p>
    <p>Age: {pirate.age}</p>
    <p>Ship: {pirate.ship.name}</p>
    </Fragment>
  )
}

export default Pirate;
