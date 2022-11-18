import React, {useEffect, useState} from 'react';
import "../static/weekly.css"
import Markdown from 'markdown-to-jsx';
import markdown from '../markdowns.json'

function App() {
    const [items,setItems]=useState([])
    //read the text of all the files from ../content
    const fetchAllFiles = async () => {

    //    loop through the files and read the text and set it to the state
        setItems([]) // to prevent the state staying the same on re-render and having the current content on page duplicated reset the state everytime this is run
        const files=markdown['files']
        for (const file of files) {
            const response = await fetch(require(`../content/${file}`));
            const text = await response.text();
            setItems(items=>[...items,text])

        }
    }
    useEffect(() => {
        //fetch all the files and set it to the state
        fetchAllFiles()
         }, []);
        // line 33: check if the thing we are trying to interpret as markdown is an empty string or not 
         return (
             <div className='parent'>
                 <h1>Weekly notes</h1>
                 <p><i>this page will keep a track of our notes made week to week</i></p>
                <div className="container"> 
                
                    {
                        items.map((i) => (
                            <>
                            <Markdown>
                                {i===""? "did you forget to put stuff in this file?": i + "\n"} 
                            </Markdown>
                            <hr style={{opacity: "0.2"}}></hr>
                            </>
                        )
                        )}

                </div>
            </div>
    );
}

export default App;