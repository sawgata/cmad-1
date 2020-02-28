import React,{Component} from "react"

class Header extends Component{
    constructor(){
        super()
        this.state={

        }
    }
    render(){
        return(
           
               <table className="headerstyle">
                   <tbody>
                   <tr>
                       <td><img src="./images/ciscowhitelogo.JPG" title="Logo" /></td>
                       <td> <span style={{"textAlign":"center","padding":"50px","fontSize":"36px","fontFace":"Arial"}}>Syslog Tool</span></td>
                   </tr>
                   </tbody>
               </table>
             
        )
    }
}
export default Header