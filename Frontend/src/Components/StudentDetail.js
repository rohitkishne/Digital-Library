import '../Styling/StudentDetail.css'
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useParams } from 'react-router-dom';
export default function StudentDetail() {

    const [book, setBook] = useState([]);

    const {id} = useParams()

    useEffect(() => {
        loadBook();
    }, []);

    const loadBook = async () => {
        const result = await axios.get("http://localhost:8080/Student/getAllStudent")
        setBook(result.data);
    };

    const deleteBook=async (id)=>{
        await axios.delete(` http://localhost:8080/Student/deleteStudent?id=${id}`);
        loadBook()
    };

    return (
        <div className='stubg'>        
            <div className='studentDetail'>
                <h1>Student Register</h1>
                <div className='studetail'>
                    <table class="table studenttable">
                        <thead>
                            <tr>
                                <th scope="col">S.No</th>
                                <th scope="col">Full Name</th>
                                <th scope="col">Email-ID</th>
                                <th scope="col">Department</th>
                                <th scope="col">Action</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                book.map((book,index) => (
                            <tr>
                                <th className='py-3' scope="row" key={index}>{index+1}</th>
                                <td className='py-3'>{book.name}</td>
                                <td className='py-3'>{book.email}</td>
                                <td className='py-3'>{book.department}</td>
                                <td className='stucol'>
                                    <Link to={`/viewDetail/${book.id}`} className='btn btn-primary stubtn'>View Detail</Link>
                                    <Link to={`/updateDetail/${book.id}`} className='btn btn-success stubtn'>Update</Link>
                                    <button className='btn btn-danger stubtn'
                                    onClick={()=>deleteBook(book.id)}
                                    >Delete</button>
                                </td>

                            </tr>
                            ))
                        }
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}
