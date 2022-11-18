import React, {useEffect, useRef, useState} from 'react';

import Markdown from 'markdown-to-jsx';
import markdown from '../markdowns.json'

function App() {
    const [items,setItems]=useState([])
    //read the text of all the files from ../content
    const fetchAllFiles = async () => {

    //    loop through the files and read the text and set it to the state
        setItems([])
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
    return (
        <div className="container">
            {
                items.map((i) => (
                    
                    <Markdown>
                        {i===""? "did you forget to put stuff in this file?": i + "\n"}
                    </Markdown>
                )
                )}

        </div>
    );
}

export default App;