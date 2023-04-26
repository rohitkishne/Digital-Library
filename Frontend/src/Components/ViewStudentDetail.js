import React from 'react'
import '../Styling/ViewStudentDetail.css'
import axios from 'axios';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
export default function ViewStudentDetail() {

    const [student, setStudent] = useState({
        id: "",
        name: "",
        email: "",
        age: "",
        department: "",
        mobNo: "",
        cardResponseDto: ""
    })

    const[issue, setIssue] = useState({
        title:"",
        author:"",
        genre:"",
        transactionNo:"",
        transactionDate: "",
        transactionStatus:""
    })

    const { id } = useParams();

    const loadStudent = async () => {
        const result = await axios.get(`http://localhost:8080/Student/getStudentById?id=${id}`);
        setStudent(result.data);
    }

    const issuedBook = async () => {
        const result = await axios.get(`http://localhost:8080/Student/studentAllBooking?id=${id}`)
        setIssue(result.data)
    }
    useEffect(() => {
        loadStudent()
        issuedBook()
    }, []);

    return (
        <div className='view'>
            <div className='studentInfo'>
                <h2>Student Detail</h2>
                <div className='topDetail'>
                    <div className='leftpart'>
                        <p>Student-ID : {student.id}</p>
                        <p>Name : {student.name}</p>
                        <p>Email-ID : {student.email}</p>
                    </div>
                    <div className='cardpart'>
                        <p>
                            <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Student Card</a>
                        </p>
                        <div class="row">
                            <div class="column">
                                <div class="collapse multi-collapse" id="multiCollapseExample1">
                                    <div class="card card-body cardDetail">
                                        <p>Issued On : {student.cardResponseDto.issueDate}</p>
                                        <p>Updated On : {student.cardResponseDto.updatedOn}</p>
                                        <p>Status : {student.cardResponseDto.status}</p>
                                        <p>Valid Till : {student.cardResponseDto.validTill}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className='rightpart'>
                        <p>Department : {student.department}</p>
                        <p>Mobile Number : {student.mobNo}</p>
                        <p>Age : {student.age}</p>
                    </div>

                </div>
            </div>
            <div className='IssueBookByStudent'>
                <div className='stuBooking'>
                    <div className='issuedBook'>
                        <table class="table booktable">
                            <thead>
                                <tr className='bookTr'>
                                    <th scope="col">S.No</th>
                                    <th scope="col">Book Title</th>
                                    <th scope="col">Author</th>
                                    <th scope="col">Genre</th>
                                    <th scope="col">Transaction No</th>
                                    <th scope="col">Transaction Date</th>
                                    <th scope="col">Transaction Status</th>

                                </tr>
                            </thead>
                            <tbody>
                                {
                                   Array.from(issue).map((issue, index) => (    
                                    <tr className='bookColTr'>
                                        <th className='py-3' scope="row" key={index}>{index+1}</th>
                                        <td className='py-3'>{issue.title}</td>
                                        <td className='py-3'>{issue.author}</td>
                                        <td className='py-3'>{issue.genre}</td>
                                        <td className='py-3'>{issue.transactionNo}</td>
                                        <td className='py-3'>{issue.transactionDate}</td>
                                        <td className='py-3'>{issue.transactionStatus}</td>
                                    </tr>
                                 ))
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    )
}
