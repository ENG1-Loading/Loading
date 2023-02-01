import { Gitgraph, templateExtend } from "@gitgraph/react";
import Header from "../SharedComponents/Header";

export default function VersionControl() {
  let options = {
    template: templateExtend("metro", {
      colors: ["gray", "#FFA500", "#FF69B4", "#00FF00", "#FFFF00", "#87CEFA"],
      commit: {
        message: {
          displayAuthor: false,
          displayHash: false
        }
      }
    })
  };
    return (
      <>
        <Header title={'Git History'} buttonName={'Github Repo'} link={'https://github.com/ENG1-Loading/Loading'}/>
        <div style={{marginBottom: '20px'}}></div>
      <Gitgraph options={options}>
        {(gitgraph) => {
          // Simulate git commands with Gitgraph API.
          const main = gitgraph.branch("main");
          
          const develop = main.branch("dev");
          const gameDev = main.branch("game-dev")
          
          main.commit("1d55802 init commit (Jake Keast)")
          main.commit("a0d9446 Create .gitignore (Charlie Wilson)")
          
          develop.commit("1d84c58 Currently site only works when state is changed manually, will find fix and push when found, will add documentation once it works (Charlie Wilson)")
          develop.commit("34bc53a added comments (Charlie Wilson)")
          develop.commit("d14e251 can read text from .md files directly (Hari Bhandari)")
          develop.commit("f436ef2 Fixed a react-markdown edgecase and a re-render bug (Charlie Wilson)")
          main.merge(develop).tag("fff238e (Hari Bhandari)")
          main.commit("05743b2 Create node.js.yml (Hari Bhandari)")
          main.commit("6bbab0c Update node.js.yml (Hari Bhandari)")
          develop.commit("5616383 added an actual homepage (Charlie Wilson)")
          develop.commit("1f577a2 gantt charts to date and base plantuml (Jake Keast)")
          develop.commit("67106e7 updated gantt progress, altered timings (Jake Keast)")
          develop.commit("8fcdb5b new gantts (Jake Keast)")
          develop.commit("df62705 logo (Jake Keast)")
          gameDev.merge(develop).tag("03ca37c (Jake Keast)")
          main.commit("ec18b7b Update deploy.yml (Hari Bhandari)")
          main.commit("f25428c Update deploy.yml (Hari Bhandari)")
          main.commit("b388f30 Update deploy.yml (Hari Bhandari)")
          main.commit("bcff310 Create deploy.yml (Hari Bhandari)")
          develop.commit("577d975 added risk assessment page to website (Charlie Wilson)")
          develop.commit("0ecae25 removed accidentally commited game folder (Charlie Wilson)")
          main.commit("f4a0295 Update deploy.yml (Hari Bhandari)")
          main.merge(develop).tag("0536dbc (Charlie Wilson)")
          gameDev.commit("c795978 new branch, game engine initial (Jake Keast)")
          gameDev.commit("7ff9d0b updated readme (Jake Keast)")
          gameDev.commit("b291522 more work done, error with world (Jake Keast)")
        }}
      </Gitgraph>
      </>
    );
  }