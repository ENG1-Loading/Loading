# Loading

  
  

### How to add md files to the website

- Install nodejs from here: https://nodejs.org/en/ (LTS version)
- Once installed open up a terminal and write npm install yarn -g (optional but yarn is a better package manager)
- Clone the repo, in your terminal navigate to the website subfolder 
- If its your first time here type in `yarn add all` (if you didnt install yarn then type `npm install`)
- Open up the website sub directory in your code editor and put the markdown file into `website/src/content` 
- Navigate to the markdowns.json file in the root src directory
Example of how to add your new markdown file to the website:

Eg. we want to add "example.md" to the website. The current markdowns.json file contents is:
```
{
	"files": [
		"hello.md",
		"no.md",
		"ok.md",
		"empty.md"
	]
}
```

We start by adding a comma at the end of `"empty.md"` and then putting `"example.md"` on the next line, so it looks like this:

```
{
	"files": [
		"hello.md",
		"no.md",
		"ok.md",
		"empty.md",
		"example.md"
	]
}
```

- Once added run the command `yarn run deploy`  (or `npm run deploy`) if this all goes well then push your changes to the main branch, if not, you did something wrong, ping me in the discord .