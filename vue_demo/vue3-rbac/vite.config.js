import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import path from "path";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    port: 3001,
    host : true,
    open :true,
    proxy: {
      '/api': {
        // target: 'http://1.116.64.64:5004/api2/',
        target: 'http://localhost:8090/sshTest/',
        ws: true,
        changeOrigin: true,
        rewrite:(path) => path.replace(/^\/api/, ''),
        // pathRewrite: {
        //   '^/api': ''
        // }
      }
    }
  },
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"),
    },
  },
});
