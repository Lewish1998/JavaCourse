import React from 'react';
import Pirate from "./Pirate"

const PirateDetail = ({pirate}) => {


    if (!pirate){
      return "Loading..."
    }

    const piratesRaids = pirate.raids.map((raid, index) => {
      return <li key={index}>{raid.location}</li>
    })

    return (
      <div className = "component">
      <Pirate pirate = {pirate}/>
      <p>Raids:</p>
      <ul>
      {piratesRaids}
      </ul>
      </div>
    )
  }

export default PirateDetail;
