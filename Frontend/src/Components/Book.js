import "../Styling/Book.css"
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate, useParams } from "react-router-dom";
export default function Book() {

    let navigate = useNavigate()

    const [book, setBook] = useState([]);

    const [issue, setIssue] = useState({
        title: "",
        genre: "",
        authorName: "",

    })

    const [bookIssue, setBookIssue] = useState({
        cardId: "",
        bookId: ""
    });


    const {cardId , bookId} = bookIssue

    const onInputChange = (e) => {
        setBookIssue({ ...bookIssue, [e.target.name]: e.target.value });
    };


    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/transaction/issueBook", bookIssue);
        navigate("/")

    };


    const { id } = useParams()

    const issueBook = async (id) => {
        const result = await axios.get(`http://localhost:8080/book/getBookById?id=${id}`);
        setIssue(result.data);
        setBookIssue({
            bookId: result.data.id,
            cardId: ""
        })
        
    }

    useEffect(() => {
        loadBook();
        issueBook();
    }, []);

    const loadBook = async () => {
        const result = await axios.get("http://localhost:8080/book/getAllBooks")
        setBook(result.data);
    };



    return (
        <>
            <div className="displaybook">
                {
                    book.map((book) => (
                        <div className="card" >
                            <div className="card-header" >
                                Book Name : {book.title}
                            </div>
                            <div className="card-body">
                                <h5 className="card-title">Author : {book.authorName}</h5>
                                <p className="card-text">Genre : {book.genre}</p>
                                <p className="card-text">Price : {book.price}</p>
                                <p className="card-text">Number of Pages : {book.noOfPages}</p>
                                <div className="bookBtn">
                                    <Link to={`/showDetail/${book.id}`} className="btn btn-primary stubtn">Show Details</Link>
                                    <button type="button" class="btn btn-danger stubtn issueBtn" data-bs-toggle="modal" data-bs-target="#exampleModal" onClick={() => issueBook(book.id)}>
                                        Issue Book
                                    </button>
                                </div>
                            </div>
                        </div>
                    ))
                }
            </div>
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5 modalh1" id="exampleModalLabel">Issue Book : {issue.title}</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body setModalBody">
                            <p className="modalP">Author Name : {issue.authorName}</p>
                            <p className="modalP">Genre : {issue.genre}</p>
                            <div className="forIssue">
                                <form className="row g-3 studentRow" onSubmit={(e) => onSubmit(e)}>
                                    <div className="col-12 text">
                                        <label for="inputAddress" className="form-label">Book-ID</label>
                                        <input type={"text"} className="form-control" id="inputAddress"
                                            style={{ textAlign: "center" }}
                                            name='bookId'
                                            value={bookId}
                                            onChange={(e) => onInputChange(e)}
                                        />
                                    </div>
                                    <div className="col-12 text">
                                        <label for="inputCardId" className="form-label">Card-ID</label>
                                        <input type={"text"} className="form-control" id="inputAddress"
                                            name='cardId'
                                            value={cardId}
                                            placeholder="Enter Your Card-ID"
                                            onChange={(e) => onInputChange(e)}
                                            required />
                                    </div>
                                    <div class="modal-footer bookissuebtn">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Issue Book</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}
