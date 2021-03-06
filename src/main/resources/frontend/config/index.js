'use strict'
// Template version: 1.3.1
// see http://vuejs-templates.github.io/webpack for documentation.

const path = require('path')
const root = process.env.API_ROOT;

module.exports = {
  dev: {

    // Paths
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',
    proxyTable: {
      '/queryUserList':{
        target:'http://119.45.216.216:8080',
        changeOrigin:true},
        '/addUser':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/loginQuery':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addContent':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryUserByUsername':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addReply':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentByUid':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyByCid':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryUsernameById':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addStar':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addSolve':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addBest':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addChallenge':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyCount':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryLastUpdateTime':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyByUid':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryCategory':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyData':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyStars':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyBest':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplySolve':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryMail':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentList':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentByTitleAndTime':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addLiked':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryLiked':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryCidByTitleAndTime':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentByCid':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addMail':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryMailByTitleAndTime':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addReplyMail':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyMailByMid':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentByKeyword':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyByKeyword':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryUserByKeyword':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/addUpdateTime':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentByCountLocation':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentByLocation':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentByCategory':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentBySelection':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/updateLoginTime':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyList':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryPoints':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryUserById':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyPage':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyWithPage':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentPage':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentWithPage':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryMailPage':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryMailWithPage':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentPageByKeyword':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryReplyPageByKeyword':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentListWithouUid':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryContentPageByCategory':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/queryRegister':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        },
        '/updateUser':{
          target:'http://119.45.216.216:8080',
          changeOrigin:true
        }

    },

    // Various Dev Server settings
    host: '0.0.0.0', // can be overwritten by process.env.HOST
    port: 8080, // can be overwritten by process.env.PORT, if port is in use, a free one will be determined
    autoOpenBrowser: false,
    errorOverlay: true,
    notifyOnErrors: true,
    poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-

    
    /**
     * Source Maps
     */

    // https://webpack.js.org/configuration/devtool/#development
    devtool: 'cheap-module-eval-source-map',

    // If you have problems debugging vue-files in devtools,
    // set this to false - it *may* help
    // https://vue-loader.vuejs.org/en/options.html#cachebusting
    cacheBusting: true,

    cssSourceMap: true
  },

  build: {
    // Template for index.html
    index: path.resolve(__dirname, '../dist/index.html'),

    // Paths
    assetsRoot: path.resolve(__dirname, '../dist'),
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',
    /**
     * Source Maps
     */

    productionSourceMap: true,
    // https://webpack.js.org/configuration/devtool/#production
    devtool: '#source-map',

    // Gzip off by default as many popular static hosts such as
    // Surge or Netlify already gzip all static assets for you.
    // Before setting to `true`, make sure to:
    // npm install --save-dev compression-webpack-plugin
    productionGzip: false,
    productionGzipExtensions: ['js', 'css'],

    // Run the build command with an extra argument to
    // View the bundle analyzer report after build finishes:
    // `npm run build --report`
    // Set to `true` or `false` to always turn it on or off
    bundleAnalyzerReport: process.env.npm_config_report
  }
}
