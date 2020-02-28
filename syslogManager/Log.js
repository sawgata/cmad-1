import React from "react"
function Log(props){
    return(
        <p>
            {props.source} {props.description} {props.syslogSeverity}
        </p>
    )
}
export default Log