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
          gameDev.commit("fcbc7dd game loads, player class done, input handling done, chef switching system implemented (Jake Keast)")
          gameDev.commit("20115c8 updated map, added more stuff (Jake Keast)")
          develop.merge(gameDev).tag("7aefa9e Merge pull request #6 from ENG1-Loading/game-dev (Jake Keast)")
          develop.commit("c758218 Made homepage link to notes/executable/risk management table/version control, and created version control page (Charlie Wilson)")

          gameDev.commit("e17e77b Added heart/reducing hearts (Charlie Wilson)")
          gameDev.commit("0ec16aa made nicer looking menu (Joshua Hills)")
          gameDev.commit("076b374 Added fail and success screen (Charlie Wilson)")
          gameDev.commit("eb9de99 Added back button but commented out for anyone to check (Charlie Wilson)")
          gameDev.commit("b65f1a7 'fixed' memory overuse? (Jake Keast)")
          gameDev.commit("f2483dd Fixed button on end screens, fixed movement for characters, added arrow above currently playing character (Charlie Wilson)")
          gameDev.commit("6d39821 fixed boxes rendering, added safe exit using ESC key (Jake Keast)")
          gameDev.commit("6c23d68 kind of physics (Jake Keast)")
          gameDev.commit("0288dd1 changed menu screen asset for licensing (Joshua Hills)")
          gameDev.commit("d2f0804 Added collision, removed third sprite (Charlie Wilson)")
          gameDev.commit("f6b93ac Made it so now two players spawn in correct positions and one of them is auto set to active state (Charlie Wilson)")
          gameDev.commit("f279343 Added some javadocs, added an npc, added receipts (Charlie Wilson)")
          gameDev.commit("ff3be96 added pressing F to get receipt, along with message box for ease of player controls (Charlie Wilson)")
          gameDev.commit("eaf49e3 added randomised ingredients to reciept (Charlie Wilson)")
          gameDev.commit("9fd85ad ingredients, recipes (Jake Keast)")
          gameDev.commit("a2cbeae Added plate moveability, ability to swap plate between chefs, a tracker for what ingredients need to be handed in (Charlie Wilson)")
          gameDev.commit("23ebea4 Food assets and crates added (Jake Keast)")
          gameDev.commit("eab2277 messages to pickup ingredients (Charlie Wilson)")
          gameDev.commit("23715c2 Added ability to pickup ingredients (Charlie Wilson)")
          gameDev.commit("65d08fc First draft of game done, added randomisation of recipe, collecting ingredients, delivering the ingredients and winning/losing (Charlie Wilson)")
          gameDev.commit("589d14b Added messages if recipe isnt correct (Charlie Wilson)")
          develop.commit("983d294 added 404 page and notes gantt charts (Hari Bhandari)")
          develop.commit("a7f4a16 added animated logo (Hari Bhandari)")
          develop.commit("b9b0f12 added animated logo and header (Hari Bhandari)")
          gameDev.commit("8cb2db8 Added walking animation to NPC (Charlie Wilson)")
          gameDev.commit("b9ba4c2 cook status food sprites + logic (Jake Keast)")
          develop.commit("b3e299c added more risks, not confirmed as of now! (Hari Bhandari)")
          develop.commit("c835355 added risk register, changed the styling too (Hari Bhandari)")
          develop.commit("4b30530 added favicon (Hari Bhandari)")
          develop.commit("0f4897b fixed typo (Hari Bhandari)")
          gameDev.commit("3d1f17a cleaned up recipes (Jake Keast)")
          gameDev.commit("9c66036 fixed heart bugs, reduced max to 3 (Jake Keast)")
          gameDev.commit("ff6aa5e oven interacts (Jake Keast)")
          gameDev.commit("ab49382 5 NPCs instead of 1 (Charlie Wilson)")
          gameDev.commit("5d4a4d9 Fixed NPC speed, and remove ingredients upon serving (Charlie Wilson)")
          gameDev.commit("b7e139f ovens (Jake Keast)")
          gameDev.commit("71f85bd cooking works (Jake Keast)")
          gameDev.commit("1593a06 Added screens to gameover (Charlie Wilson)")
          develop.commit("250693a added images for architecture (Hari Bhandari)")
          develop.commit("e36460a added architechure page (Hari Bhandari)")
          develop.commit("6e907c5 added jar file (Hari Bhandari)")
          develop.commit("8bccd68 added deliverables page and made home page responsive! (Hari Bhandari)")
          develop.commit("0d8e51f Update Notes.js (Hari Bhandari)")
          develop.commit("8ebabbb added download links and worked on notes (Hari Bhandari)")
          develop.commit("f828d4c added uml, for first part(safe commit) (Hari Bhandari)")
          develop.commit("db2f113 hopefully, final commit. (Hari Bhandari)")
          gameDev.commit("6683518 Added javadocs, removed some unnecessary lines (Charlie Wilson)")
          gameDev.commit("eea18f5 (origin/game-dev) Fixed bugs previous commit accidentally had (Charlie Wilson)")
          gameDev.commit("227e290 final commit, comments and javadocs (Jake Keast)")
          gameDev.commit("8819332 Added jar, removed every debug print (Charlie Wilson)")
          develop.commit("6e6510e changed title and added size on deliverables (Hari Bhandari)")
          develop.commit("b41bea3 changed the downlaod file name (Hari Bhandari)")
          gameDev.merge(develop);
          main.merge(gameDev);
          main.commit("1f81e9d Added zip containing jar and assets, and added it to the website (Charlie Wilson)")
          main.commit("c94171b Changed website from calling it game.jar to game.zip (Charlie Wilson")

        }}
      </Gitgraph>
      </>
    );
  }