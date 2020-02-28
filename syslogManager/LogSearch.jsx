import React,{Component} from "react"
import moment from 'moment';
import {DatetimePickerTrigger} from 'rc-datetime-picker';
import { DateTimePicker } from 'react-widgets'
 

class LogSearch extends Component{
    constructor(){
        super()
        this.state={
            startmoment:moment(),
            endmoment:moment()
        }
        this.handleChange=this.handleChange.bind(this)
        this.handleChange2=this.handleChange2.bind(this)
        this.handleSearch=this.handleSearch.bind(this)
    }
   
    
    handleChange(moment) {
        this.setState({
          startmoment:moment
        });
      }
      handleChange2(moment){
        this.setState({
          endmoment:moment
        })
      }
      handleSearch(){
        console.log("Start date:"+this.state.startmoment +" End date:"+this.state.endmoment);
      }
     
    render(){      
        const shortcuts = {
            'Today': moment(),
            'Yesterday': moment().subtract(1, 'days'),
           
          };

        return(
            <div className="logsearchstyle">
              <table><tbody>
<tr>
  <td> Start Date:</td>
<td><DatetimePickerTrigger
        shortcuts={shortcuts} 
        moment={this.state.startmoment}
        onChange={this.handleChange}>
        <input type="text" value={this.state.startmoment} readOnly />
      </DatetimePickerTrigger></td>
      <td>End Date:</td>
      <td><DatetimePickerTrigger
        shortcuts={shortcuts} 
        moment={this.state.endmoment}
        onChange={this.handleChange2}>
        <input type="text" value={this.state.endmoment} readOnly />
      </DatetimePickerTrigger></td>
      <td colSpan="2"><button onClick={this.handleSearch}>Search</button></td>
</tr>
</tbody>
              </table>
               
               
            </div>
        )
    }
}

export default LogSearch