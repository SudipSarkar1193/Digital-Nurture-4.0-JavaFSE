import React, { useState } from "react";
import CourseDetails from "./CourseDetails";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import "./App.css";

// Duummy data for courses, books, and blogs
const coursesData = [
  { id: 1, name: "Angular", date: "4/5/2021" },
  { id: 2, name: "React", date: "6/3/2021" },
  { id: 3, name: "Java", date: "6/3/2021" },
  { id: 4, name: "Spring Boot", date: "6/3/2021" },
];

const booksData = [
  { id: 101, bname: "Master React", price: 670 },
  { id: 102, bname: "Deep Dive into Angular 11", price: 800 },
  { id: 103, bname: "Mongo Essentials", price: 450 },
  { id: 104, bname: "Spring Boot Essentials", price: 650 },
];

const blogsData = [
  {
    id: 1,
    title: "React Learning",
    author: "Stephen Biz",
    content: "Welcome to learning React!",
  },
  {
    id: 2,
    title: "Installation",
    author: "Schcezdenier",
    content: "You can install React from npm.",
  },
  {
    id: 3,
    title: "Spring Boot Learning",
    author: "Durga Sir",
    content: "You can Create a Spring Boot project from Spring initializer.",
  },
];

function App() {
  const [show, setShow] = useState("all"); 

  // Method 1: Using switch statement to conditionally render components
  const renderContent = () => {
    switch (show) {
      case "courses":
        return (
          <div className="single-view">
            <CourseDetails courses={coursesData} />
          </div>
        );
      case "books":
        return (
          <div className="single-view">
            <BookDetails books={booksData} />
          </div>
        );
      case "blogs":
        return (
          <div className="single-view">
            <BlogDetails blogs={blogsData} />
          </div>
        );
      default:
        // If 'show' is 'all', render all components
        return (
          <div className="container">
            <div className="column">
              <CourseDetails courses={coursesData} />
            </div>
            <div className="column">
              <BookDetails books={booksData} />
            </div>
            <div className="column">
              <BlogDetails blogs={blogsData} />
            </div>
          </div>
        );
    }
  };

  return (
    <div className="App">
      <div className="buttons">
        <button onClick={() => setShow("all")}>Show All</button>
        <button onClick={() => setShow("courses")}>Show Courses</button>
        <button onClick={() => setShow("books")}>Show Books</button>
        <button onClick={() => setShow("blogs")}>Show Blogs</button>
      </div>

      <hr />

      {/* Method 2: Logical && Operator - Renders only if the condition is true */}
      {show === "all" && <h1>Showing All Details</h1>}

      {renderContent()}

      {/* Method 3 : Ternary operator - show a message if a component is hidden */}
      <div className="footer-note">
        {show !== "all" ? (
          <p>
            Displaying a single component. Click "Show All" to see everything.
          </p>
        ) : (
          <p>Displaying all available components.</p>
        )}
      </div>
    </div>
  );
}

export default App;
