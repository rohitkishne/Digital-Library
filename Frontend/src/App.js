
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Book from './Components/Book';
import Home from './Components/Home';
import Navbar from './Components/Navbar';
import BookDetail from './Components/BookDetail';
import AddStudent from './Components/AddStudent';
import AddBook from './Components/AddBook'
import StudentDetail from './Components/StudentDetail';
import ViewStudentDetail from './Components/ViewStudentDetail';
import UpdateStudent from './Components/UpdateStudent'
import Transaction from './Components/Transaction';
function App() {
  return (
    <div className="App">
      <Router>
        <Navbar/>
        <Routes>
          <Route exact path="/" element={<Home/>} />
          <Route exact path="/LibraryBook" element={<Book/>} />  
          <Route exact path="/showDetail/:id" element={<BookDetail/>} />  
          <Route exact path="/enrollStudent" element={<AddStudent/>} />  
          <Route exact path="/addBook" element={<AddBook/>} />  
          <Route exact path="/studentDetail" element={<StudentDetail/>} />  
          <Route exact path="/viewDetail/:id" element={<ViewStudentDetail/>} />  
          <Route exact path="/updateDetail/:id" element={<UpdateStudent/>} />  
          <Route exact path="/transactions" element={<Transaction/>} /> 

        </Routes>
      </Router>
      

      
    </div>
  );
}

export default App;
