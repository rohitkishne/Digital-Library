import React from 'react'
import "../Styling/Home.css"

export default function Home() {
    return (
        <div className='home'>
            <div id="carouselExampleAutoplaying" className="carousel slide" data-bs-ride="carousel">
                <div className="carousel-inner">
                    <div className="carousel-item ">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Salle_de_lecture_Biblioth%C3%A8que_Mazarine_depuis_gallerie.jpg/1200px-Salle_de_lecture_Biblioth%C3%A8que_Mazarine_depuis_gallerie.jpg" className="d-block w-100" alt="..." />
                        <div className="carousel-caption d-none d-md-block">
                            <h5>LibraryBook</h5>
                            <p>LibraryBook</p>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <img src="https://www.ucdavis.edu/sites/default/files/styles/sf_landscape_16x9/public/media/images/shields-library-research-uc-davis.jpg?h=8e58fdb5&itok=iTi1yLT7" className="d-block w-100" alt="..." />
                        <div className="carousel-caption d-none d-md-block">
                            <h5>First slide label</h5>
                            <p>Some representative placeholder content for the first slide.</p>
                        </div>
                    </div>
                    <div className="carousel-item active ">
                        <img src="https://columbiabc.edu/wp-content/uploads/2022/04/DSC_4436-2.jpg" className="d-block w-100" alt="..." />
                        <div className="carousel-caption d-none d-md-block">
                            <h5>A.P.J Abdul Kalam -</h5>
                            <p>"The best brains of the nations may be found on the last benches of the classrooms."</p>
                        </div>
                    </div>
                </div>
                <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Previous</span>
                </button>
                <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    )
}
