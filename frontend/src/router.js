
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import CookingManager from "./components/listers/CookingCards"
import CookingDetail from "./components/listers/CookingDetail"

import RideManager from "./components/listers/RideCards"
import RideDetail from "./components/listers/RideDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/cookings',
                name: 'CookingManager',
                component: CookingManager
            },
            {
                path: '/cookings/:id',
                name: 'CookingDetail',
                component: CookingDetail
            },

            {
                path: '/rides',
                name: 'RideManager',
                component: RideManager
            },
            {
                path: '/rides/:id',
                name: 'RideDetail',
                component: RideDetail
            },



    ]
})
