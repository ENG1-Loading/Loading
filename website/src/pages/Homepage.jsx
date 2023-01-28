import { ClipLoader } from "react-spinners"
import "../static/home.css"
import jar from "../piazza-panic.jar"
import AnimatedLogo from "../SharedComponents/AnimatedLogo";
import Header from "../SharedComponents/Header";
export default function Homepage() {

    return (
        <div>
            <Header title={'Piazza Panic'} />
            <div className="parent">
            <div className="boxParent">
                <div className="boxChild">
                    <div className="box">
                        <div className="boxContent">
                            <h3>Deliverables</h3>
                            <p>Click the button below to be redirected to our page with the pdfs to all deliverables</p>
                            <button>Go to page</button>                       
                        </div>
                    </div>
                    <div className="box">
                    <div className="boxContent">
                            <h3>Executable jar</h3>
                            <p>Please click the button below to download the executable jar of our game, or the button below to view all versions</p>
                            <a href={jar} download="game.jar" target='_blank'>
                            <button>Download</button>
                            </a>
                        </div>
                    </div>
                </div>
                    <div className="boxChild">
                    <div className="box">
                    <div className="boxContent">
                            <h3>Version control</h3>
                            <p>Please click the button to be redirected to our page which has the version control history of our repository</p>
                            <button onClick={(e) => {
                                e.preventDefault()
                                window.open(`${process.env.PUBLIC_URL}/version_control`, "_blank")
                            }}>Go to page</button>
                        </div>

                    </div>
                    <div className="box">
                    <div className="boxContent">
                            <h3>Architecture & Method selection</h3>
                            <p>Please click the button below to be redirected to our page which contains explaining/reasoning behind why we chose specific technologies</p>
                            <button>Go to page</button>
                        </div>
                    </div>
                </div>
                </div>
                    <div className="boxChild">
                    <div className="box">
                    <div className="boxContent">
                            <h3>Risk Management</h3>
                            <p>Please click the button to be redirected to our page which has the risk management table</p>
                            <button onClick={(e) => {
                                e.preventDefault()
                                window.open( `${process.env.PUBLIC_URL}/risk_assessment`, "_blank")
                            }}>Go to page</button>
                        </div>

                    </div>
                    <div className="box">
                    <div className="boxContent">
                            <h3>Notes</h3>
                            <p>Please click the button to be redirected to our page which has all the notes</p>
                            <button onClick={(e) => {
                                e.preventDefault()
                                window.open(`${process.env.PUBLIC_URL}/notes`, "_blank")
                            }}>Go to page</button>
                        </div>

                    </div>

            </div>
            
            </div>
            


        </div>
    )
}

