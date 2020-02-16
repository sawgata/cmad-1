import React, {Component} from "react"
import Header from "./Header.jsx"
import LogSearch from "./LogSearch.jsx"
import Notifications from "./Notifications.jsx"
import Logresults from "./Logresults.jsx"

class Dashboard extends Component{
   constructor(){
       super()
   }
   render(){
       return (
           <div style={{"marginLeft":"20%","marginTop":"5%","marginRight":"20%","border": "1px solid gray","height":"80%","overflow":"auto"}}>             
             <br />
             <Header />
             <LogSearch />
             <Notifications />
             <Logresults />
           </div>
       )
   }
}
export default Dashboard