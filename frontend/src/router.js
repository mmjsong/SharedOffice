
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OfficeManager from "./components/listers/OfficeCards"
import OfficeDetail from "./components/listers/OfficeDetail"
import ReviewManager from "./components/listers/ReviewCards"
import ReviewDetail from "./components/listers/ReviewDetail"

import ReservationManager from "./components/listers/ReservationCards"
import ReservationDetail from "./components/listers/ReservationDetail"

import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import NotificationManager from "./components/listers/NotificationCards"
import NotificationDetail from "./components/listers/NotificationDetail"


import OfficeviewView from "./components/OfficeviewView"
import OfficeviewViewDetail from "./components/OfficeviewViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/offices',
                name: 'OfficeManager',
                component: OfficeManager
            },
            {
                path: '/offices/:id',
                name: 'OfficeDetail',
                component: OfficeDetail
            },
            {
                path: '/reviews',
                name: 'ReviewManager',
                component: ReviewManager
            },
            {
                path: '/reviews/:id',
                name: 'ReviewDetail',
                component: ReviewDetail
            },

            {
                path: '/reservations',
                name: 'ReservationManager',
                component: ReservationManager
            },
            {
                path: '/reservations/:id',
                name: 'ReservationDetail',
                component: ReservationDetail
            },

            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/notifications',
                name: 'NotificationManager',
                component: NotificationManager
            },
            {
                path: '/notifications/:id',
                name: 'NotificationDetail',
                component: NotificationDetail
            },


            {
                path: '/officeviews',
                name: 'OfficeviewView',
                component: OfficeviewView
            },
            {
                path: '/officeviews/:id',
                name: 'OfficeviewViewDetail',
                component: OfficeviewViewDetail
            },


    ]
})
