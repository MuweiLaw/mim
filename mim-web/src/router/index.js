import { createRouter, createWebHashHistory } from "vue-router";
import IndexView from "../views/IndexView.vue";

const routes = [
  {
    path: "/",
    name: "index",
    component: IndexView,
  },
  {
    path: "/tts",
    name: "tts",
    children: [
      {
        path: "process",
        name: "ttsProcessView",
        component: () => import("../views/tts/TtsProcessView.vue"),
      },
    ],
  },
  {
    path: "/chat",
    name: "chat",
    children: [
      {
        path: "person",
        name: "chatPersonView",
        component: () => import("../views/chat/ChatPersonView.vue"),
      },
    ],
  },
  {
    path: "/test",
    name: "test",
    component: () => import("../views/TestView.vue"),
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/home",
    name: "home",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/HomeView.vue"),
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
