import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function Transaction() {

    const [transaction, setTransaction] = useState([]);

    useEffect(() => {
        loadTransaction();
    }, []);

    const loadTransaction = async () => {
        const result = await axios.get("http://localhost:8080/transaction/getAllTransaction")
        setTransaction(result.data);
    };

  return (
    <div className='stubg'>        
            <div className='studentDetail'>
                <h1>ALL Transactions</h1>
                <div className='studetail'>
                    <table class="table studenttable">
                        <thead>
                            <tr>
                                <th scope="col">S.No</th>
                                <th scope="col">Student Name</th>
                                <th scope="col">Book Name</th>
                                <th scope="col">Transaction Number</th>
                                <th scope="col">Transaction Date</th>
                                <th scope="col">Transaction For</th>
                                <th scope="col">Transaction Status</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                transaction.map((transaction,index) => (
                            <tr>
                                <th className='py-3' scope="row" key={index}>{index+1}</th>
                                <td className='py-3'>{transaction.studentName}</td>
                                <td className='py-3'>{transaction.bookName}</td>
                                <td className='py-3'>{transaction.transactionNumber}</td>
                                <td className='py-3'>{transaction.transactionDate}</td>
                                <td className='py-3'>{transaction.issueOperation}</td>
                                <td className='py-3'>{transaction.transactionStatus}</td>
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
