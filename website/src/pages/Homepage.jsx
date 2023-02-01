import "../static/home.css"
import jar from "../piazza-panic.zip"
import Header from "../SharedComponents/Header";
import {Link} from "react-router-dom";
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
                            <Link to="/deliverables">
                            <button>Go to page</button>
                            </Link>
                        </div>
                    </div>
                    <div className="box">
                    <div className="boxContent">
                            <h3>Executable jar</h3>
                            <p>Please click the button below to download the executable jar of our game, or the button below to view all versions</p>
                            <a href={jar} download="game.zip" target='_blank'>
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
                        <Link to="/version_control">
                            <button>Go to page</button>
                        </Link>
                        </div>

                    </div>
                    <div className="box">
                    <div className="boxContent">
                            <h3>Architecture & Method selection</h3>
                            <p>Please click the button below to be redirected to our page which contains explaining/reasoning behind why we chose specific technologies</p>
                        <Link to={"/architecture"}>
                            <button>Go to page</button>
                        </Link>
                        </div>
                    </div>
                </div>
                </div>
                    <div className="boxChild">
                    <div className="box">
                    <div className="boxContent">
                            <h3>Risk Management</h3>
                            <p>Please click the button to be redirected to our page which has the risk management table</p>
                        <Link to={"/risk_assessment"}>
                        <button >Go to page</button>
                        </Link>
                        </div>

                    </div>
                    <div className="box">
                    <div className="boxContent">
                            <h3>Notes</h3>
                            <p>Please click the button to be redirected to our page which has all the notes</p>
                        <Link to={"/notes"}>
                            <button >Go to page</button>
                        </Link>
                        </div>
                    </div>

            </div>

            </div>



        </div>
    )
}

