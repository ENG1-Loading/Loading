import { ClipLoader } from "react-spinners"
import "../static/home.css"
export default function Homepage() {
    return (
        <div>
            <h1><u>Loading...</u><ClipLoader
                color="#FFFFFF"
                loading={true}
                
                size={20}
                aria-label="Loading Spinner"
                data-testid="loader"
            /></h1>
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
                            <button>Download</button>
                        </div>
                    </div>
                </div>
                    <div className="boxChild">
                    <div className="box">
                    <div className="boxContent">
                            <h3>Version control</h3>
                            <p>Please click the button to be redirected to our page which has the version control history of our repository</p>
                            <button>Go to page</button>
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
            
            </div>
            


        </div>
    )
}

