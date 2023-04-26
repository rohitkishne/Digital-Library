import React from 'react'
import "../Styling/AddStudent.css"
import axios from 'axios';
import { useState } from 'react';

export default function AddBook() {
  const [book, setBook] = useState({
    title: "",
    genre: "",
    noOfPages: "",
    price: "",
    imageLink:"",
    description:"",
    authorId:""
});

const { title, genre, noOfPages, price, imageLink, description, authorId } = book

const onInputChange = (e) => {
    setBook({ ...book, [e.target.name]: e.target.value })
};

const onSubmit = async (e) => {
    e.preventDefault();
    const data = await axios.post("http://localhost:8080/book/addBook", book);
    console.log(data.title);
    setBook({
      title: "",
      genre: "",
      noOfPages: "",
      price: "",
      imageLink:"",
      description:"",
      authorId:""
    })
};
  return (
    <div className='addBook'>
       <form className="row g-3 studentRow" onSubmit={(e)=>onSubmit(e)}>
                <div className="col-12 text">
                    <label for="inputEmail4" className="form-label">Title</label>
                    <input 
                    type={"text"}
                    className="form-control" 
                    id="inputEmail4" 
                    placeholder="Enter Title of the Book" 
                    name='title'
                    value={title}
                    onChange={(e) => onInputChange(e)}
                    required/>
                </div>
                <div className="col-12 text">
                    <label for="inputAddress" className="form-label">Author-ID</label>
                    <input type={"text"} className="form-control" id="inputAddress" placeholder="Enter Author-ID of the Book" 
                     name='authorId'
                     value={authorId}
                     onChange={(e) => onInputChange(e)}
                    required/>
                </div>
                <div className="col-12 text">
                    <label for="inputAddress2" className="form-label">Genre</label>
                    <input type={"text"} className="form-control" id="inputAddress2" placeholder="Enter Genre of the Book" 
                     name='genre'
                     value={genre}
                     onChange={(e) => onInputChange(e)}
                    required/>
                </div>
                <div className="col-12 text">
                    <label for="inputCity" className="form-label">Page Count</label>
                    <input type={"text"} className="form-control" id="inputCity"placeholder="Enter Page Count of the Book" 
                     name='noOfPages'
                     value={noOfPages}
                     onChange={(e) => onInputChange(e)}
                    required/>
                </div>
                <div className="col-12 text">
                    <label for="inputCity" className="form-label">Price</label>
                    <input type={"text"} className="form-control" id="inputCity"placeholder="Enter Price of the Book" 
                     name='price'
                     value={price}
                     onChange={(e) => onInputChange(e)}
                    required/>
                </div>
                <div className="col-12 text">
                    <label for="inputCity" className="form-label">Image Link</label>
                    <input type={"text"} className="form-control" id="inputCity" placeholder="Enter Image Link of Book" 
                     name='imageLink'
                     value={imageLink}
                     onChange={(e) => onInputChange(e)}
                    required/>
                </div>
                <div className="col-12 text">
                    <label for="inputCity" className="form-label">Description</label>
                    <textarea className="form-control textarea" id="inputCity" placeholder="Describe About the Book..." 
                    type={"text"}
                    name="description" 
                    value={description}
                    onChange={(e) => onInputChange(e)}
                    required
                    />
                    
                </div>
                          
                <div className="col-12 text">
                    <button type="submit" className="btn btn-primary btnstyle">Register</button>
                </div>
        </form>
    </div>
  )
}
