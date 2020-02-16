import React,{Component} from "react"

class Header extends Component{
    constructor(){
        super()
        this.state={

        }
    }
    render(){
        return(
            <div><img src="./images/ciscowhitelogo.JPG" title="Logo" /><span >Syslog Monitor</span></div>
        )
    }
}
export default Header