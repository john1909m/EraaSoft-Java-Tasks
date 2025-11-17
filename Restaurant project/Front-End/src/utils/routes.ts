
import { Component } from "react";
import SiteLayout from "../layout/SiteLayout";
import { createBrowserRouter } from "react-router-dom";
import About from "../Pages/About/About";
import App from "../App";
import path from "path";
import Team from "../Pages/Team/Team";
export const routes = createBrowserRouter([
    {
        path: "/",
        Component:SiteLayout,
        children: [
            {path: "/", Component: App},
            {path: "/Team", Component: Team}

        ]
    }
])
