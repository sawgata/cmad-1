
import React,{Component} from "react"
import {DataTable} from 'react-data-table-component'

class Logresults extends Component{
    constructor(){
        super()
        this.state ={
           logs:[]
        }
    }
    componentDidMount() {
        fetch('http://localhost:8080/syslog').then(response => {
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
        var newlogs;
        if(alllogs.length>0){
              newlogs = alllogs.map(log=>{
                return(
                 log
                )
              })
        }

        console.log(this.state.logs)
        return(
            
    <div className="logsearchresultsstyle">
      <span>Search Results:</span>
      {/*{{newlogs}} */}   
      

    </div>

        )
    }
}

export default Logresults

