import React from 'react'
import '../Styling/BookDetail.css'
import axios from 'axios';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
export default function BookDetail() {
  const [book, setBook] = useState({
      title: "",
      genre: "",
      price: 0,
      noOfPages: 0,
      imageLink: "",
      description: "",
      authorName: ""
  })

  const { id } = useParams();

  const loadBook = async () => {
    const result = await axios.get(`http://localhost:8080/book/getBookById?id=${id}`);
    setBook(result.data);
  }
  useEffect(() => {
    loadBook()
  },[]);

  return (
    <div className="bookdetail">
      <div className="container text-center">
        <div className="row">
          <div className="col">
            <img src={book.imageLink} alt=''/>
          </div>
          <div className="col about">
            <h5>About the Book</h5>
            <p>{book.description}</p>
          </div>
          <div className="col desc">
            <p>Book Name : {book.title}</p>
            <p>Author : {book.authorName}</p>
            <p>Genre : {book.genre}</p>
            <p>Price : {book.price}</p>
            <p>Page Count : {book.noOfPages}</p>
          </div>
        </div>
      </div>
    </div>
  )
}
