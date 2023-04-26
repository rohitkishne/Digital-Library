import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

export default function UpdateStudent() {

  let navigate=useNavigate()

    const{id} = useParams()

    const [user, setUser] = useState({
      name: "",
      email: "",
      age: "",
      mobNo: "",
      department:""
    });

    const { name, email, age, mobNo, department } = user

    const onInputChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });
    };

    useEffect(()=>{
        loadUser()
    },[]);

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.put("http://localhost:8080/Student/updateStudentDetails", user);
        navigate("/studentDetail")
        
    };

    const loadUser = async()=>{
        const result=await axios.get(`http://localhost:8080/Student/getStudentById?id=${id}`, user);
        setUser(result.data);
    }

  return (
    <div className="addStudent">
      <form className="row g-3 studentRow" onSubmit={(e) => onSubmit(e)}>
        <div className="col-12 text">
          <label for="inputEmail4" className="form-label">Email-ID</label>
          <input
            type={"email"}
            className="form-control"
            id="inputEmail4"
            placeholder="Enter Your Email-Id"
            name='email'
            value={email}
            onChange={(e) => onInputChange(e)}
            required />
        </div>
        <div className="col-12 text">
          <label for="inputAddress" className="form-label">Full Name</label>
          <input type={"text"} className="form-control" id="inputAddress" placeholder="Enter Your Full Name"
            name='name'
            value={name}
            onChange={(e) => onInputChange(e)}
            required />
        </div>
        <div className="col-12 text">
          <label for="inputAddress2" className="form-label">Mobile Number</label>
          <input type={"text"} className="form-control" id="inputAddress2" placeholder="Enter Your Personal Mobile Number"
            name='mobNo'
            value={mobNo}
            onChange={(e) => onInputChange(e)}
            required />
        </div>
        <div className="col-12 text">
          <label for="inputCity" className="form-label">Age</label>
          <input type={"text"} className="form-control" id="inputCity" placeholder="Enter Your Age"
            name='age'
            value={age}
            onChange={(e) => onInputChange(e)}
            required />
        </div>
        <div className="col-12 text">
          <label for="inputState" className="form-label">Department</label>
          <select id="inputState" className="form-select"
            name='department'
            value={department}
            onChange={(e) => onInputChange(e)}
          >
            <option selected>Choose Your Department...</option>
            <option>CSE</option>
            <option>IT</option>
            <option>ECE</option>
            <option>MECH</option>
            <option>AUTO</option>
            <option>EEE</option>
            <option>BIOTECH</option>
          </select>
        </div>
        <div className="col-12 text">
          <button type="submit" className="btn btn-primary btnstyle">Update</button>
        </div>
      </form>
    </div>
  )
}
