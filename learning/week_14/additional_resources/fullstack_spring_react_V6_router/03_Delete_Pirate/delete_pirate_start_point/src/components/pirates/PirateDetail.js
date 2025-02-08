import React from 'react';
import Pirate from "./Pirate";

const PirateDetail = ({pirate}) => {

    if(pirate){

        const piratesRaids = pirate.raids.map((raid, index) => {
            return <li key={index}>{raid.location}</li>
          })

          

        
        return(

            <div className = "component">
                <Pirate pirate={pirate}/>
                <p>Raids:</p>
                <ul>
                {piratesRaids}
                </ul>
                <p>Ship:</p>
                <p>{pirate.ship.name}</p>
            </div>
            
        )

    }
    return(
        <p>Loading.....</p>
    )



}

export default PirateDetail;