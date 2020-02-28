
import React,{Component} from "react"
import Log from "./Log"
import {DataTable} from 'react-data-table-component'

class Logresults extends Component{
    constructor(){
        super()
        this.state ={
           logs:[]
        }
    }
    componentDidMount() {
        fetch('http://localhost:8082/syslog').then(response => {
           response.json().then(o => {
             this.setState({
               logs:o
             })
           })
        });
     }

    render(){
        console.log("this is logs from state");
        const alllogs = this.state.logs
        var newlogs=[];
        if(alllogs.length>0){
              newlogs = alllogs.map(log=>{
                return(
                  <Log key={log.id} source={log.source} description={log.description} syslogSeverity={log.syslogSeverity} />
                )
              })
        }

        console.log(this.state.logs)
        console.log(newlogs)
        return(

    <div className="logsearchresultsstyle">
      <span>Source | Error Message | Error Type</span>
         {newlogs}


    </div>

        )
    }
}

export default Logresults

