import React from 'react';
import '../Styling/Navbar.css';
import { Link } from 'react-router-dom';
export default function Navbar() {
    return (
        <div className='navstyle'>
            <nav className="navbar navbar-expand-lg navbg">
                <div className="container-fluid">
                    <img src="https://w7.pngwing.com/pngs/147/513/png-transparent-learning-management-system-course-computer-icons-educational-technology-others-miscellaneous-angle-text.png" alt="Bootstrap" width="80" height="50" style={{ mixBlendMode: 'darken' }} />
                    <a className="navbar-brand" href="/">
                        LMS
                    </a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <Link className="nav-link active" style={{ color: "white" }} aria-current="page" to="/">Home</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link active" style={{ color: "white" }} aria-current="page" to="/LibraryBook">Books</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link active" style={{ color: "white" }} aria-current="page" to="/StudentDetail">Student Details</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link active" style={{ color: "white" }} aria-current="page" to="/transactions">Transaction</Link>
                            </li>
                            
                        </ul>
                    </div>
                    <Link to="/enrollStudent" className='bttn'>Enroll Student</Link>
                    <Link to="/addBook" className='bttn'>New Book</Link>
                </div>
            </nav>
        </div>
    )
}
