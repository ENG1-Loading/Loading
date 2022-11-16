import React, { useEffect, useRef } from 'react';

import Markdown from 'markdown-to-jsx';
import currentPosts from "../markdowns.json"

function App() {

    const itemsRef = useRef([]);
    useEffect(() => {
         for (let i of currentPosts["files"]) {
            console.log("here")
            import(`../content/${i}`)
            .then(res => {
                fetch(res.default)
                    .then(res => res.text())
                    .then(res => {itemsRef.current.push(res)})
                    .catch(err => console.log("error here", err));
            })
            .catch(err => console.log("errrrr",err));
        }

        
    }, []);
    console.log(itemsRef.current)
    return (
        <div className="container">
            {
                itemsRef.current.map((i) => (
                    <Markdown>
                        {i}
                    </Markdown>
                )
                )}
            <Markdown>
                *hi**
                
            </Markdown>
        </div>
    );
}

export default App;