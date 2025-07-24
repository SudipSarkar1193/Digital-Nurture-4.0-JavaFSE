Create the react app using :

```bash
npm create-react-app blogapp
```

## Codes

### App.js

```js
// src/App.js
import React from 'react';
import './App.css';
import Posts from './posts';

function App() {
  return (
    <div className="App">
      <Posts />
    </div>
  );
}

export default App;

```

### post.js

```js
import React from 'react';

class post extends React.Component {
  render() {
    const { title, body } = this.props;
    return (
      <div style={{ border: '1px solid #ccc', margin: '10px', padding: '10px' }}>
        <h2>{title}</h2>
        <p>{body}</p>
      </div>
    );
  }
}

export default post;

```

### posts.js

```js
import React from 'react';
import Post from './post'; 

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      errorInfo: '',
    };
  }

  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Failed to fetch posts');
        }
        return response.json();
      })
      .then((data) => this.setState({ posts: data }))
      .catch((error) => {
        console.error('Fetch error:', error);
        this.setState({ hasError: true, errorInfo: error.message });
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    console.error('Render error:', error, info);
    alert('Something went wrong while rendering the posts.');
    this.setState({ hasError: true, errorInfo: error.message });
  }

  render() {
    const { posts, hasError, errorInfo } = this.state;

    if (hasError) {
      return <h1 style={{ color: 'red' }}>Error: {errorInfo || 'Unable to render posts'}</h1>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {posts.map((post) => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;

```

## Ouput

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week6_React/4.%20ReactJS-HOL/blogapp/Output_Screenshot/Output.png?raw=true)