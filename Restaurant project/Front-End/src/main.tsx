import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { RouterProvider } from 'react-router'
import { Provider } from "react-redux";
import { Store } from "./store/store.ts";
import { routes } from './utils/routes.ts'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
// import App from './App.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <Provider store={Store}>
      <RouterProvider router={routes}/>
    </Provider>
  </StrictMode>
)
