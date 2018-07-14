var     gulp         = require('gulp'),
        stylus         = require('gulp-stylus'),
        browserSync  = require('browser-sync').create();

var autoprefixer = require('autoprefixer-stylus');

gulp.task('browser-sync', function() {
    browserSync.init({
        server: {
            baseDir: "./public"
        },
        notify: false
    });
});

gulp.task('stylus', function () {
    gulp.src('./styl/*.styl')
    .pipe(stylus())
    .pipe(gulp.dest('./public'))
    .pipe(browserSync.stream({
      use: [autoprefixer('iOS >= 7', 'last 1 Chrome version')]
    }));
});

gulp.task('watch', function () {
  gulp.watch('styl/*.styl', ['stylus']);
  gulp.watch('public/js/*.js').on("change", browserSync.reload);
  gulp.watch('public/*.html').on('change', browserSync.reload);
});

gulp.task('default', ['browser-sync', 'watch']);