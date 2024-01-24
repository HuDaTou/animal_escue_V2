<template>
	<div class="diy_edit page_volunteer_application" id="volunteer_application_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
						<div v-if="$check_field('set','user_no') || $check_field('add','user_no') || $check_field('get','user_no')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								用户编号:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_user_no" :disabled="disabledObj['user_no_isDisabled']" v-model="form['user_no']" v-if="(form['user_no'] && $check_field('set','user_no')) || (!form['user_no'] && $check_field('add','user_no'))" >
								<option v-for="o in list_user_user_no" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','user_no')">{{ form['user_no'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','user_name') || $check_field('add','user_name') || $check_field('get','user_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								用户姓名:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_user_name" v-model="form['user_name']" placeholder="请输入用户姓名" v-if="(form['user_name'] && $check_field('set','user_name')) || (!form['user_name'] && $check_field('add','user_name'))"  :disabled="disabledObj['user_name_isDisabled']"/>
							<span v-else-if="$check_field('get','user_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','application_time') || $check_field('add','application_time') || $check_field('get','application_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								申请时间:
							</span>
						</div>
								<!-- 日期 -->
						<div class="diy_field diy_date">
							<input type="date" :disabled="disabledObj['application_time_isDisabled']" id="form_application_time" v-model="form['application_time']" placeholder="请输入申请时间" v-if="(form['application_time'] && $check_field('set','application_time')) || (!form['application_time'] && $check_field('add','application_time'))" />
							<span v-else-if="$check_field('get','application_time')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','reason_for_application') || $check_field('add','reason_for_application') || $check_field('get','reason_for_application')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								申请原因:
							</span>
						</div>
								<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_reason_for_application" v-model="form['reason_for_application']" v-if="(form['reason_for_application'] && $check_field('set','reason_for_application')) || (!form['reason_for_application'] && $check_field('add','reason_for_application'))" :disabled="disabledObj['reason_for_application_isDisabled']" />
							<span v-else-if="$check_field('get','reason_for_application')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','personal_profile') || $check_field('add','personal_profile') || $check_field('get','personal_profile')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								个人简介:
							</span>
						</div>
								<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_personal_profile" v-model="form['personal_profile']" v-if="(form['personal_profile'] && $check_field('set','personal_profile')) || (!form['personal_profile'] && $check_field('add','personal_profile'))"  :disabled="disabledObj['personal_profile_isDisabled']"/>
							<view v-else-if="$check_field('get','personal_profile')" v-html="form['${obj.name}']"></view>
						</div>
							</div>
	


					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/volunteer_application/edit','examine')">
							<!--<span> {{ form['examine_state'] }} </span>-->
							<select v-model="form['examine_state']">
								<option value="未审核">
									未审核
								</option>
								<option value="已通过">
									已通过
								</option>
								<option value="未通过">
									未通过
								</option>
							</select>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_state'] }}
							</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核回复:
							</span>
						</div>
						<div class="diy_field diy_desc" v-if="$check_action('/volunteer_application/edit','examine')">
							<textarea v-model="form['examine_reply']"></textarea>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_reply'] }}
							</span>
						</div>
					</div>


				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/volunteer_application/get_obj?",
				url_add: "~/api/volunteer_application/add?",
				url_set: "~/api/volunteer_application/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"user_no": 0,
							"user_name": "",
							"application_time": "",
							"reason_for_application": "",
							"personal_profile": "",
						"volunteer_application_id": 0,
				},

				obj: {
						"user_no": 0, // 用户编号
							"user_name":  '', // 用户姓名
							"application_time": new Date().getTime(),
							"reason_for_application":  '', // 申请原因
							"personal_profile":  '', // 个人简介
						"examine_state": "未审核",
					"examine_reply": "",
					"volunteer_application_id": 0,
				},

				// 表单字段
				form: {
						"user_no": 0, // 用户编号
							"user_name":  '', // 用户姓名
							"application_time": new Date().getTime(),
							"reason_for_application":  '', // 申请原因
							"personal_profile":  '', // 个人简介
						"examine_state": "未审核",
					"examine_reply": "",
					"volunteer_application_id": 0,
				},
				disabledObj:{
						"user_no_isDisabled": false,
							"user_name_isDisabled": false,
							"application_time_isDisabled": false,
							"reason_for_application_isDisabled": false,
							"personal_profile_isDisabled": false,
					},

						// 用户列表
				list_user_user_no: [],
									
				// ID字段
				field: "volunteer_application_id",

			}
		},
		methods: {
					/**
			 * 获取注册用户用户列表
			 */
			async get_list_user_user_no() {
				// if(this.user_group !== "管理员" && this.form["user_no"] === 0) {
				//     this.form["user_no"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=注册用户");
				if(json.result && json.result.list){
					this.list_user_user_no = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
					async get_user_session_user_no(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=注册用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["user_no"] = user_id
								_this.disabledObj['user_no' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "user_no") {
                          _this.form[arrForm[j]] = res.result.obj[arr[i]]
                          _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                          break;
                        }
                      }
                    }
                  }
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
				
				
				
				
	
			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/volunteer_application/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
        //   this.obj = $.push(this.obj ,form);
				// 	this.form = $.push(this.form ,form);
				// }
				// var arr = []
				// for (let key in form) {
				// 	arr.push(key)
				// }
				// for (var i=0;i<arr.length;i++){
				// 	this.disabledObj[arr[i] + '_isDisabled'] = true
				// }
        if (form) {
          var arr = []
          for (let key in form) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arrForm[j] === arr[i]) {
                  this.form[arrForm[j]] = form[arr[i]]
                  this.obj[arrForm[j]] = form[arr[i]]
                  this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  break;
                }
              }
            }
          }
        }
						        if (JSON.stringify(this.form["application_time"]).indexOf("-")===-1) {
          this.form["application_time"] = this.$toTime(parseInt(this.form["application_time"]), "yyyy-MM-dd")
        }
					
        $.db.del("form");
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				// var form = $.db.get("form");
				// var obj = Object.assign({} ,form ,this.obj);
				// if (obj) {
        //   delete(obj.examine_state)
        //   delete(obj.examine_reply)
				// 	this.obj = $.push(this.obj ,obj);
				// }
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
				// 	this.form = $.push(this.form ,form);
				// }
				if(func){
					func(json);
				}
			},


		},
		created() {
					this.get_user_session_user_no();
					this.get_list_user_user_no();
															},
	}
</script>

<style>




</style>
