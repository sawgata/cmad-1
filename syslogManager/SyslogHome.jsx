import React from 'react';

class SearchForm extends React.Component {
   constructor(props) {
      super(props);
      this.state = { key: '' }

      this.onKey = (e) => this.setState({ key: e.target.value })

      this.onSearch = () => {
         this.props.onSearch(this.state.key);
         this.setState({ key: '' });
      }
   }
   render() {
      return (
         <table>
            <tbody>
               <tr><td>Search </td><td><input value={this.state.key} onChange={this.onKey} /></td><td><button onClick={this.onSearch}>{this.props.label}</button></td></tr>
            </tbody>
         </table>
      )
   }
}

class SearchResults extends React.Component {
   render() {
      return (
         <table width='100%'>
            <tbody>
               <tr style={{backgroundColor: 'black', color: 'white'}}><th>ISBN</th><th>Name</th><th>Author</th><th>Price</th></tr>
               {
                  this.props.results.map(book => <tr><td>{book.isbn}</td><td>{book.name}</td><td>{book.author}</td><td>{book.price}</td></tr>)
               }
            </tbody>
         </table>
      )
   }
}

class Library extends React.Component {
   constructor(props) {
      super(props);
      this.state = { results: [] }

      this.onSearchBySubject = (subject) => {
         fetch(`http://localhost:8080/book?subject=${subject}`).then(response => {
            response.json().then(books => {
               this.setState({
                  results: books
               })
            })
         })
      }

      this.onSearchByISBN = (isbn) => {
         fetch(`http://localhost:8080/book/${isbn}`).then(response => {
            response.json().then(book => {
               this.setState({
                  results: [book]
               })
            })
         })         
      }
   }
   render() {
      return (
         <div>
            <h1>Online Library</h1>
            <hr/>
            <SearchForm onSearch={this.onSearchBySubject} label="Search By Subject"/>
            <SearchForm onSearch={this.onSearchByISBN} label="Search by ISBN"/>
            <hr/>
            <h3>Search Results</h3>
            <SearchResults results={this.state.results}/>
         </div>
      )
   }
}

export default Library;